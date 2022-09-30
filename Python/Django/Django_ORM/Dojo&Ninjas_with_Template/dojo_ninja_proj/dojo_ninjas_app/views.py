from multiprocessing import context
from unicodedata import name
from urllib import request
from django.shortcuts import render, HttpResponse,redirect
from .models import *
def index(request):
    context={
        'dojos':Dojo.objects.all()
    }
    return render(request,"dojo.html",context)


def adddojo(request):
    name= request.POST['dojo_name']
    city=request.POST['dojo_city']
    state=request.POST['dojo_state']
    Dojo.objects.create(name=name,city=city,state=state)

    return redirect ('/')

def addninja(request):
    firstname=request.POST['ninja_first']
    lastname=request.POST['ninja_last']
    selectdojo=Dojo.objects.get(id=request.POST['dojo_select'])
    Ninja.objects.create(first_name=firstname,last_name=lastname,dojo=selectdojo)

    return redirect ('/')


