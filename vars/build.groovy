def call(String username , String image, String tag){
  echo "Image Building Started.."
  sh "docker build -t ${username}/${image}:${tag} ."
  echo "Image Building Ended.."
}
