from django.shortcuts import render, HttpResponse,redirect
from .models import *

def index(request):
    context={
        'users': User.objects.all()
    }
    return render(request,'user.html',context)

def adduser(request):
    firstname=request.POST['first_name']
    lastname=request.POST['last_name']
    email=request.POST['email']
    age=request.POST['age']
    User.objects.create(first_name=firstname,last_name=lastname,email=email,age=age)

    return redirect ('/')
