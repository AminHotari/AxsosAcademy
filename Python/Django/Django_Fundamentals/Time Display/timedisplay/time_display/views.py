from django.shortcuts import render, HttpResponse, redirect
from time import gmtime, strftime

# def index(request):
#     return HttpResponse("Welcom")

def time(request):
    context = {
        "time": strftime("%b %d,%Y %H:%M %p", gmtime())
    }
    return render(request,'time.html', context)

def time1(request):
    return redirect('/') 



