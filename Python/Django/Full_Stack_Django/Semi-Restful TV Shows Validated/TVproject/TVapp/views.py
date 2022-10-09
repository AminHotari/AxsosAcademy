from django.shortcuts import render,redirect,HttpResponse
from .models import Show
from time import gmtime, strftime
from django.contrib import messages

def index(request):
    return redirect ('/shows')

def shows(request):
    context={
        'shows':Show.objects.all(),
        'time': strftime("%m %d,%Y", gmtime())
    }
    return render (request,'shows.html',context)

def shows_new(request):
    context={
        'show':Show.objects.all()
    }
    return render(request,'add_new_show.html',context)

def create(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/shows/new')
    else:
        title=request.POST['title']
        network=request.POST['network']
        date=request.POST['date']
        desc=request.POST['desc']
        Show.objects.create(title=title,network=network,release_date=date,description=desc)
        return redirect('/shows')
    
def show_detaile(request,id):
    context={
        'detaile':Show.objects.get(id=int(id))
    }
    return render(request,'read.html',context)

def edit(request,id):
    context={
        'edit':Show.objects.get(id=int(id))
    }
    return render(request,'edit.html',context)

def update(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f'/shows/{update.id}/edit')
    else:
        update=Show.objects.get(id=int(request.POST['hide']))
        update.title=request.POST['title']
        update.network=request.POST['network']
        update.release_date=request.POST['date']
        update.description=request.POST['desc']
        update.save()
        return redirect(f'/shows/{update.id}')

def destroy(request,id):
    destroy=Show.objects.get(id=int(id))
    destroy.delete()
    return redirect('/shows')

