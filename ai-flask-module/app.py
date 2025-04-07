from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/plan", methods=["POST"])
def generate_plan():
    data = request.get_json()
    topics = data.get("topics", [])
    time_available = data.get("timeAvailable", 0)

    if not topics or time_available <= 0:
        return jsonify({"error": "Invalid input"}), 400

    # Distribute time evenly
    time_per_topic = round(time_available / len(topics), 2)
    schedule = {topic: time_per_topic for topic in topics}

    return jsonify(schedule)

if __name__ == "__main__":
    app.run(port="5005",debug=True)
