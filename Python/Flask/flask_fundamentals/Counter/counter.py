from distutils.log import debug
from flask import Flask, render_template,session,redirect
app= Flask(__name__)
app.secret_key='secret'

@app.route('/')
def counter():
    if 'count' not in session:
        session['count'] = 1
    else:
        session['count'] += 1

    return render_template('counter.html')

@app.route('/destroy_session')
def destroy():
    session.pop('count')
    return redirect('/')

@app.route('/add2', methods=["post"])
def add2():
    session['count'] +=1
    return redirect('/')

@app.route('/reset', methods=["post"])
def reset():
    session['count'] =0
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)