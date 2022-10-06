import email
from multiprocessing import context
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
        request.session['first_name'] = User.objects.last().first_name
        request.session['email'] = request.POST['email']
        return redirect('/books')

def books(request):
    user=User.objects.get(email=request.session['email'])
    context={
        'books':Book.objects.all(),
        'user':user
    }
    return render(request,'books.html',context)

def login(request):
    login_user=User.objects.filter(email=request.POST['email1'])
    if login_user:
        logged_user = login_user[0]
        if bcrypt.checkpw(request.POST['password1'].encode(),logged_user.password.encode()):
            request.session['userid'] = logged_user.id            
            messages.success(request,"login successful!")
            request.session['first_name'] = logged_user.first_name
            request.session['email'] = request.POST['email1']
            return redirect('/books')
        messages.error(request,"invaled password")
        return redirect('/')
    messages.error(request,"invalid user")       
    return redirect("/")

def addbook(request):
    title = request.POST['title']
    desc = request.POST['desc']
    user = User.objects.get(email = request.session['email'])
    Book.objects.create(title=title,desc=desc,uploaded_by=user)
    book=Book.objects.last()
    book.liked_by.add(user)
    return redirect('/books')
    
def bookdetaile(request,id):
    context={
        'book':Book.objects.get(id = int(id)),
        'users':User.objects.get(email=request.session['email'])
    }
    return render (request,'bookdetaile.html',context)

def addfav(request,id):
    user=User.objects.get(email=request.session['email'])
    book=Book.objects.get(id= int(id))
    book.liked_by.add(user)
    return redirect('/books')

def delete(request,id):
    book= Book.objects.get(id= int(id))
    book.delete()
    return redirect('/books')

def update(request,id):
    book = Book.objects.get(id = int(id))
    book.title = request.POST['book_title']
    book.desc = request.POST['book_desc']
    book.save()
    messages.success(request,"Update Complete")
    return redirect(f'/books/{id}')

def unfav(request,id):
    book=Book.objects.get(id=int(id))
    user=User.objects.get(email=request.session['email'])
    book.liked_by.remove(user)
    return redirect(f'/books/{id}')

def addto(request,id):
    book=Book.objects.get(id=int(id))
    user=User.objects.get(email=request.session['email'])
    book.liked_by.add(user)
    return redirect(f'/books/{id}')


def logout(request):
    del request.session['email']
    return redirect('/')

    