from django.shortcuts import redirect, render,HttpResponse
from .models import *
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
        request.session['first_name'] = User.objects.last().firstname
        request.session['email'] = request.POST['email']
        return redirect('/wall')

def success(request):
    return redirect('/wall')

def login(request):
    login_user=User.objects.filter(email=request.POST['email1'])
    if login_user:
        logged_user = login_user[0]
        if bcrypt.checkpw(request.POST['password1'].encode(),logged_user.password.encode()):
            request.session['user-id'] = logged_user.id
            messages.success(request,"login successful!")
            request.session['first_name'] = logged_user.first_name
            request.session['email'] = request.POST['email1']
            return redirect('/wall')
        messages.error(request,"invaled password")
        return redirect('/')
    messages.error(request,"invalid user")       
    return redirect("/")




