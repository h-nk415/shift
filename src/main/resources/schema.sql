-- テーブルの作成
CREATE TABLE IF NOT EXISTS shifts (
	--　ID
	id serial primary key,
	--　シフト日
	shift_date date not null,
	--　開始時間
	start_time TIME not null,
	--　終了時間
	end_time TIME not null,
	-- 休憩時間
	break_time TIME
	);
	
	