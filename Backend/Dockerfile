FROM node:20

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN cd Transaction-Schedule-Analyzer-1/src && \
    find . -name "*.java" | xargs javac

EXPOSE 8080

CMD ["npm", "start"]