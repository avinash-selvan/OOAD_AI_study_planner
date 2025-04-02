# Use Python base image
FROM python:3.9

# Set working directory
WORKDIR /app

# Copy application files
COPY app.py /app
COPY requirements.txt /app

# Install dependencies
RUN pip install flask redis

# Expose port 5000
EXPOSE 5000

# Run the app
CMD ["python", "app.py"]

