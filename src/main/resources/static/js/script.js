let addBtn = document.getElementById('addTodoBtn');
let closeModalBtn = document.getElementById('closeModalBtn');

addBtn.addEventListener('click', () => {
    document.getElementById('modal').classList.toggle('display-none');
});

closeModalBtn.addEventListener('click', () => {
    document.getElementById('modal').classList.toggle('display-none');
});