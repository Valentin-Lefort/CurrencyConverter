window.onload = function() {
    const dropdownButton = document.getElementById("dropdown-fiat-currency-button");
    const dropdownMenu = document.getElementById("dropdown-fiat-currency");

    if(dropdownButton) {
        dropdownButton.addEventListener("click", function() {
            dropdownMenu.classList.toggle("hidden");
        });
    }

    window.onclick = function(event) {
        if (!event.target.matches('#dropdown-fiat-currency-button')) {
            if (!dropdownMenu.classList.contains('hidden')) {
                dropdownMenu.classList.add('hidden');
            }
        }
    }
}