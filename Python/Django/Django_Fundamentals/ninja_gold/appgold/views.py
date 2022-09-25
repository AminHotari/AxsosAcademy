from datetime import datetime
from django.shortcuts import render,HttpResponse,redirect
import random
from time import gmtime, strftime
def index(request):
    return render(request,"gold.html")

def process(request):
    random1= random.randint(10,20)
    if 'num' in request.session:
        request.session['num']+=random1
    else:
        request.session['num']=random1

    if request.POST['find'] == 'Farm':
        request.session['Activity'] = f"You Entered a farm and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
        request.session['list'] +=[request.session['Activity']]

    elif request.POST['find'] == 'Cave':
        request.session['Activity'] = f"You Entered a cave and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
        request.session['list'] +=[request.session['Activity']]

    elif request.POST['find'] == 'House':
        request.session['Activity'] = f"You Entered a house and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
        request.session['list'] +=[request.session['Activity']]
    return redirect('/')

def process1(request):
    random1= random.randint(-50,50)
    random_operation= random.choice(['+','-'])
    if 'num' in request.session:
        if random_operation == '+':
            request.session['num']+=random1
            request.session['Activity'] = f"You Entered a quest and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
            request.session['list'] +=[request.session['Activity']]
           
        
        else:
            request.session['num']-=random1
            request.session['Activity'] = f"You Entered a quest and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
            request.session['list'] +=[request.session['Activity']]


    else:
        if random_operation == '+':
            request.session['num']=random1
            request.session['Activity'] = f"You Entered a quest and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
            request.session['list'] +=[request.session['Activity']]
        else:
            request.session['num']=random1 *-1
            request.session['Activity'] = f"You Entered a quest and earned {random1} Golds." + '('+ str(datetime.now().strftime("%b-%d-%Y %H:%M-%p")) + ')'
            request.session['list'] +=[request.session['Activity']]

    return redirect('/')
    
