def call(String username , String image, String tag){
  sh "docker build -t ${username}/${image}:${tag} ."
}
