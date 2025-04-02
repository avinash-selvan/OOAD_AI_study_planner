from flask import Flask, request, redirect
import redis
import random
import string

app = Flask(__name__)
r = redis.Redis(host='redis', port=6379, decode_responses=True)

def generate_short_url():
    return ''.join(random.choices(string.ascii_letters + string.digits, k=6))

@app.route('/shorten', methods=['POST'])
def shorten_url():
    long_url = request.json.get("url")
    short_url = generate_short_url()
    r.set(short_url, long_url)
    return {"short_url": f"http://localhost:5000/{short_url}"}

@app.route('/<short_url>')
def redirect_url(short_url):
    long_url = r.get(short_url)
    if long_url:
        return redirect(long_url)
    return "URL not found", 404

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)

