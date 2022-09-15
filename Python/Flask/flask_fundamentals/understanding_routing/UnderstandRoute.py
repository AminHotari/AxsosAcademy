from flask import Flask
app = Flask(__name__)


@app.errorhandler(404)
def page_not_found(error):
    return "Sorry! No response. Try again", 404
    
@app.route("/")
def hello():
    return "Hello World!"

@app.route("/dojo")
def dojo():
    return "Dojo!"

@app.route("/say/<name>")
def say(name):
    return f" Hi {name}"

@app.route("/repeat/<number>/<name>")
def repeat(number,name):
    return f"{name} "*int(number)


@app.route("/bonus/<number>/<name>")
def bonus(number,name):

    return f"{int(number)} {name}"

if __name__ == "__main__":
    app.run(debug=True)