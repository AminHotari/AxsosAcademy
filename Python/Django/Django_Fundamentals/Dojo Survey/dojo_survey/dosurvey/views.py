from django.shortcuts import render, redirect

def survey(request):
    return render(request, "dojosurvey.html")

def result(request):
    if request.method == 'POST':
        context = {
        'name1' : request.POST['name'],
        'location1' : request.POST['location'],
        'language1' : request.POST['language'],
        'comment1' : request.POST['comment'],

    }
        return render(request, "dojosurvey1.html", context)

    else:
        return redirect('/')