function handleActive() {
	const activeLink = document.querySelector(".nav-link.active");
	console.log(activeLink);
	const element = event.target;
	activeLink.classList.remove("active");
	element.classList.add("active");
}

/*function handelToggleLike() {
	const likeElement = event.target;
	likeElement.classList.toggle("active");
}
 */