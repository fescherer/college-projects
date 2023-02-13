
//Home
var i = 0; 			// inicio da variavel i
var images = [];	// array das imagens
var time = 5000;	// tempo

// Lista de imagens
images[0] = "img_home/imagem1.png";
images[1] = "img_home/imagem2.png";
images[2] = "img_home/imagem3.png";
images[3] = "img_home/imagem4.png";

// troca a imagem
function changeImg(){
	document.slide.src = images[i]; // o .slide é o name da tag img no html

	// impede que o número do array seja maior que a quantidade de imagens
	if(i < images.length - 1){
	  // adiciona 1 no número do array
	  i++;
	} else {
		// reseta para 0
		i = 0;
	}

	// roda a função por tantos segundos
	setTimeout("changeImg()", time);
}

// roda a função quando abrir a página
window.onload=changeImg;



//Formulário
function alerta() {
	alert("Formulário enviado")
}
