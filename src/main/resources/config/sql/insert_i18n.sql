/*
 * 다국어 데이터
 */

insert into i18n_lang values ('en', '영어');
insert into i18n_lang values ('ko', '한국어');
insert into i18n_lang values ('ja', '영어');

insert into i18n values ('web.title', '웹페이지 타이틀', 'Multi Language Sample');
insert into i18n_dtl values ('web.title', 'ko', '다국어 샘플');
insert into i18n_dtl values ('web.title', 'ja', '多言語のサンプル');

insert into i18n values ('link.home', '홈으로', 'Home');
insert into i18n_dtl values ('link.home', 'ko', '홈으로');
insert into i18n_dtl values ('link.home', 'ja', 'ホーム');

insert into i18n values ('link.location.list', '주소 목록', 'Location List');
insert into i18n_dtl values ('link.location.list', 'ko', '주소 목록');
insert into i18n_dtl values ('link.location.list', 'ja', '場所リスト');

insert into i18n values ('link.i18n.list', '다국어 관리', 'Manage Language');
insert into i18n_dtl values ('link.i18n.list', 'ko', '다국어 관리');
insert into i18n_dtl values ('link.i18n.list', 'ja', '多言語の管理');

insert into i18n values ('link.back', '이전으로', 'Back');
insert into i18n_dtl values ('link.back', 'ko', '이전으로');
insert into i18n_dtl values ('link.back', 'ja', 'バック');

insert into i18n values ('link.register', '등록', 'Register');
insert into i18n_dtl values ('link.register', 'ko', '등록');
insert into i18n_dtl values ('link.register', 'ja', '登録');

insert into i18n values ('location.title.location.id', '주소 - 아이디', 'Location ID');
insert into i18n_dtl values ('location.title.location.id', 'ko', '아이디');
insert into i18n_dtl values ('location.title.location.id', 'ja', '身元');

insert into i18n values ('location.title.street.address', '주소 - 번지', 'Street Address');
insert into i18n_dtl values ('location.title.street.address', 'ko', '번지');
insert into i18n_dtl values ('location.title.street.address', 'ja', 'アドレス');

insert into i18n values ('location.title.postal.code', '주소 - 우편번호', 'Postal Code');
insert into i18n_dtl values ('location.title.postal.code', 'ko', '우편번호');
insert into i18n_dtl values ('location.title.postal.code', 'ja', '郵便番号');

insert into i18n values ('location.title.city', '주소 - 시', 'City');
insert into i18n_dtl values ('location.title.city', 'ko', '시');
insert into i18n_dtl values ('location.title.city', 'ja', 'シティー');

insert into i18n values ('location.title.state.province', '주소 - 주', 'Province');
insert into i18n_dtl values ('location.title.state.province', 'ko', '주');
insert into i18n_dtl values ('location.title.state.province', 'ja', '県');

insert into i18n values ('i18n.title.code', '다국어 - 코드', 'Code');
insert into i18n_dtl values ('i18n.title.code', 'ko', '코드');
insert into i18n_dtl values ('i18n.title.code', 'ja', 'コード');

insert into i18n values ('i18n.title.desc', '다국어 -  설명', 'Description');
insert into i18n_dtl values ('i18n.title.desc', 'ko', '설명');
insert into i18n_dtl values ('i18n.title.desc', 'ja', '説明');

insert into i18n values ('i18n.title.message', '다국어 -  메세지', 'Message');
insert into i18n_dtl values ('i18n.title.message', 'ko', '메세지');
insert into i18n_dtl values ('i18n.title.message', 'ja', 'メッセージ');

insert into i18n values ('i18n.title.language', '다국어 -  언어', 'Language');
insert into i18n_dtl values ('i18n.title.language', 'ko', '언어');
insert into i18n_dtl values ('i18n.title.language', 'ja', '言語');

insert into i18n values ('i18n.title.edit', '다국어 -  편집', 'Edit');
insert into i18n_dtl values ('i18n.title.edit', 'ko', '편집');
insert into i18n_dtl values ('i18n.title.edit', 'ja', '編集');

insert into i18n values ('paging.link.first', '페이징 - 처음', 'First');
insert into i18n_dtl values ('paging.link.first', 'ko', '처음');
insert into i18n_dtl values ('paging.link.first', 'ja', '最初');

insert into i18n values ('paging.link.prev', '페이징 - 이전', 'Prev');
insert into i18n_dtl values ('paging.link.prev', 'ko', '이전');
insert into i18n_dtl values ('paging.link.prev', 'ja', 'ぜん');

insert into i18n values ('paging.link.next', '페이징 - 다음', 'Next');
insert into i18n_dtl values ('paging.link.next', 'ko', '다음');
insert into i18n_dtl values ('paging.link.next', 'ja', '次の');

insert into i18n values ('paging.link.last', '페이징 - 마지막', 'Last');
insert into i18n_dtl values ('paging.link.last', 'ko', '마지막');
insert into i18n_dtl values ('paging.link.last', 'ja', '最後');

insert into i18n values ('button.save', '버튼 - 저장', 'Save');
insert into i18n_dtl values ('button.save', 'ko', '저장');
insert into i18n_dtl values ('button.save', 'ja', 'セーブ');

insert into i18n values ('button.reset', '버튼 - 리셋', 'Reset');
insert into i18n_dtl values ('button.reset', 'ko', '리셋');
insert into i18n_dtl values ('button.reset', 'ja', 'リセット');

insert into i18n values ('common.modify', '수정', 'Modify');
insert into i18n_dtl values ('common.modify', 'ko', '수정');
insert into i18n_dtl values ('common.modify', 'ja', '修正する');

insert into i18n values ('common.remove', '삭제', 'Remove');
insert into i18n_dtl values ('common.remove', 'ko', '삭제');
insert into i18n_dtl values ('common.remove', 'ja', '除く');

insert into i18n values ('confirm.remove', '삭제 질문', 'Are you sure you want to delete?');
insert into i18n_dtl values ('confirm.remove', 'ko', '삭제하시겠습니까?');
insert into i18n_dtl values ('confirm.remove', 'ja', 'あなたが削除してもよろしいですか？');
