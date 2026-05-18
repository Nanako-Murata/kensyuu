const imageInput = document.getElementById('imageFile');
const imagePreview = document.getElementById('imagePreview');

imageInput.addEventListener('change', () => {

    const file = imageInput.files[0];

    // ファイル未選択
    if (!file) {
        imagePreview.innerHTML = '';
        return;
    }

    // 画像以外を弾く
    if (!file.type.startsWith('image/')) {
        imagePreview.innerHTML = `
            <p class="text-danger">
                画像ファイルを選択してください。
            </p>
        `;
        return;
    }

    const fileReader = new FileReader();

    fileReader.onload = () => {

        imagePreview.innerHTML = `
            <img
                src="${fileReader.result}"
                class="img-fluid mb-3 rounded shadow-sm"
                alt="画像プレビュー"
            >
        `;
    };

    fileReader.readAsDataURL(file);
});