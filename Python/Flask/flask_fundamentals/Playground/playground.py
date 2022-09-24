from flask import Flask, render_template
app = Flask(__name__)
@app.route('/play/<num>/<color>')
def playground(num,color):
    return render_template("playdround.html",number=int(num),color=color)

if __name__ == "__main__":
    app.run(debug=True)