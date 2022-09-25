from multiprocessing import context
from django.shortcuts import render, HttpResponse,redirect
import random
def index(request):
    request.session['random']=random.randint(1, 100)
    return render(request, 'game.html')

def random1(request):
    if request.method == "POST":
        print(request.POST)
        context = {
            "Submit" : int(request.POST["Number"])
        }
        
    return render(request,"game.html",context)
