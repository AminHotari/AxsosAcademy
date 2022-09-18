from turtle import color
from flask import Flask, render_template
app = Flask(__name__)

@app.route("/<x>/<y>/<color1>/<color2>")
def hello_world(x,y,color1,color2):
    return render_template('checker.html',num1=int(x),num2=int(y),color1=color1,color2=color2)


if __name__ == "__main__":
    app.run(debug=True)