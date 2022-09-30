from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('addbook',views.addbook),
    path('books/<int:id>',views.viewbook),
    path('addauthor/<int:id>',views.addauthor),
    path('authors',views.authors),
    path('addauthor',views.addauthors),
    path('authors/<int:id>',views.viewauthor),
    path('addbooks/<int:id>',views.addbooks),   
]
