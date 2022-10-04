from email import message
import email
from multiprocessing import context
from venv import create
from django.shortcuts import render,redirect
from .models import *

def index(request):
    context = {
        'messages': Message.objects.all().order_by("-created_at")        
    }   
    return render(request,'wall.html', context)


def postmessage(request):
    message = request.POST['message']
    user = User.objects.get(email = request.session['email'])
    Message.objects.create(message=message,users=user)
    return redirect('/wall')

def postcomment(request):
    comment = request.POST['comment']
    user = User.objects.get(email = request.session['email'])
    message = Message.objects.get(id = int(request.POST['which_message']))
    Comment.objects.create(comment=comment,users=user,messages=message)
    return redirect ('/wall')

def delete(request):
    message = Message.objects.get(id = int(request.POST['which_message']))
    message.delete()
    return redirect ('/wall')



