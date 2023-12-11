// navigation script
document
	.querySelector(".form-control-borderless")
	.addEventListener("keypress", function(e) {
		if (e.keyCode === 13) {
			e.preventDefault();
			console.log('hello')
			const keyword = this.value.trim();
			if (!keyword && keyword != ' ') return;
			console.log(`/SOCIALMEDIA/admin-manage/user/searchUser?keyword=${keyword}`)
			window.location.href = `/SOCIALMEDIA/admin-manage/user/searchUser?keyword=${keyword}`;
			this.value = keyword;
		}
	});
