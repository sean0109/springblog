// 탭 전환 기능
document.addEventListener('DOMContentLoaded', function() {
    const navTabs = document.querySelectorAll('.nav-tab');

    navTabs.forEach(tab => {
        tab.addEventListener('click', function() {
            // 모든 탭에서 active 클래스 제거
            navTabs.forEach(t => t.classList.remove('active'));

            // 클릭된 탭에 active 클래스 추가
            this.classList.add('active');

            // TODO: 나중에 AJAX로 게시글 필터링 구현
            const tabType = this.dataset.tab;
            console.log('Selected tab:', tabType);
        });
    });

    // 드롭다운 모바일 대응
    const dropdown = document.querySelector('.dropdown');
    const dropdownBtn = document.querySelector('.btn-my');

    if (dropdownBtn) {
        dropdownBtn.addEventListener('click', function(e) {
            e.stopPropagation();
            const content = dropdown.querySelector('.dropdown-content');
            content.style.display = content.style.display === 'block' ? 'none' : 'block';
        });
    }

    // 드롭다운 외부 클릭 시 닫기
    document.addEventListener('click', function(e) {
        if (!dropdown.contains(e.target)) {
            const content = dropdown.querySelector('.dropdown-content');
            if (content) {
                content.style.display = 'none';
            }
        }
    });
});
