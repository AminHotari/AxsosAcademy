from django.shortcuts import redirect, render,HttpResponse
from .models import User
from django.contrib import messages
import bcrypt


def index(request):
    return render(request,'login.html')

def register(request):
    users=User.objects.all() 
    errors = User.objects.basic_validator(request.POST)
    for user in users:
        if user.email == request.POST['email']:
            errors['email']="This email already exist"
    if len(errors) > 0:
        for key, Value in errors.items():
            messages.error(request, Value)
        return redirect('/')
    else:
        firstname = request.POST['first_name']
        lastname = request.POST['last_name']
        email = request.POST['email']
        password = request.POST['password']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        User.objects.create(first_name=firstname, last_name=lastname, email=email, password=pw_hash)
        request.session['first_name'] = User.objects.last().first_name
        return redirect('/success')

def success(request):
    return render(request,'success.html')

def login(request):
    login_user=User.objects.filter(email=request.POST['email1'])
    if login_user:
        logged_user = login_user[0]
        if bcrypt.checkpw(request.POST['password1'].encode(),logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            messages.success(request,"login successful!")
            return redirect('/success')
        messages.error(request,"invaled password")
        return redirect('/')
    messages.error(request,"invalid user")       
    return redirect("/")
