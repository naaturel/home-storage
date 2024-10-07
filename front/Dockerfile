FROM node:latest as build

ENV NODE_ENV=production

WORKDIR /app

COPY package.json ./

RUN npm install --include=dev

COPY . .

RUN npm run build

FROM nginx:alpine AS production

COPY --from=build /app /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]