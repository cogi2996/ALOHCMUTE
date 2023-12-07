document.addEventListener("DOMContentLoaded", function () {
    // Thêm sự kiện click cho tất cả các icon close
    document.querySelectorAll(".close").forEach(function (icon) {
      icon.addEventListener("click", function () {
        // Tìm card chứa icon close và toggle class js-hidden-card
        icon.closest(".card").classList.toggle("js-hidden-card");
      });
    });
  });
  document.querySelectorAll(".send").forEach(function (locationIcon) {
    locationIcon.addEventListener("click", function () {
      // Chuyển màu và làm mờ nút
      locationIcon.style.color = "#cccccc";
      locationIcon.style.pointerEvents = "none";
    });
  });