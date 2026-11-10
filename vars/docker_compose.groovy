def call(){
  sh "docker compose down && docker compose up --build"
}
