# Use Node LTS image
FROM node:18-alpine

# Create working directory
WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install --production

# Copy source code
COPY . .

# Expose port
EXPOSE 5050

# Run the app
CMD ["npm", "start"]
