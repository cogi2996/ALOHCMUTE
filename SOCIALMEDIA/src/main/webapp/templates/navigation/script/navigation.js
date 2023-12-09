// navigation script
document
  .querySelector(".nav__search")
  .addEventListener("keypress", function (e) {
    if (e.keyCode === 13) {
      const keyword = this.value.trim();
      if (!keyword&& keyword !=' ') return;

      window.location.href = `/SOCIALMEDIA/timkiem?keyword=${keyword}`;
      this.value = keyword;
    }
  });
