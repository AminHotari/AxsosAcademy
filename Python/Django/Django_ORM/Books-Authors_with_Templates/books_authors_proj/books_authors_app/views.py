from django.shortcuts import render,HttpResponse,redirect
from .models import *

def index(request):
    context={
        'books':Book.objects.all()
    }
    return render (request,'book.html',context)

def addbook(request):
    title=request.POST['book_title']
    desc=request.POST['book_desc']

    Book.objects.create(title=title,desc=desc)
    return redirect ('/')

def viewbook(request,id):
    context={
        'book':Book.objects.get(id=int(id)),
        'book_author':Author.objects.all()
    }
    return render (request,'viewbook.html',context)

def addauthor(request,id):
    book_view = Book.objects.get(id=int(id))
    author_view = Author.objects.get(id=request.POST['remain_author'])
    book_view.authors.add(author_view)
    return redirect ('/books/' + str(id))

def authors(request):
    context={
        'authors':Author.objects.all()
    }
    
    return render (request,'author.html',context)

def addauthors(request):
    firsname=request.POST['author_first']
    lastname=request.POST['author_last']
    notes=request.POST['author_note']
    Author.objects.create(first_name=firsname,last_name=lastname,notes=notes)
    return redirect ('/authors')

def viewauthor (request,id):
    context={
        'author_detail':Author.objects.get(id=int(id)),
        'author_book':Book.objects.all()
    }
    return render (request,'viewauthor.html',context)

def addbooks(request,id):
    view_author=Author.objects.get(id=int(id))
    view_book=Book.objects.get(id=request.POST['remain_book'])
    view_author.books.add(view_book)
    return redirect ('/authors/' + str(id))