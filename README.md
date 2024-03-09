# Andis Dev
## Tools common


## Input DDL 

-- laravel.dbo.dmkh definition

-- Drop table

-- DROP TABLE laravel.dbo.dmkh;

CREATE TABLE laravel.dbo.dmkh (
	ma_kh nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	ten_kh nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	ten_kh2 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	kh_yn int NULL,
	cc_yn int NULL,
	nv_yn int NULL,
	ma_so_thue nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	dia_chi int NULL,
	dien_thoai int NULL,
	fax int NULL,
	e_mail nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	home_page int NULL,
	doi_tac int NULL,
	ong_ba int NULL,
	ma_nvbh nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	ngan_hang int NULL,
	tk_nh int NULL,
	tinh_thanh int NULL,
	ghi_chu int NULL,
	ma_tt nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	tk int NULL,
	nh_kh1 int NULL,
	nh_kh2 int NULL,
	nh_kh3 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	nh_kh9 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	du_nt13 int NULL,
	du13 int NULL,
	t_tien_cn int NULL,
	t_tien_hd int NULL,
	ngay_gh datetime DEFAULT getdate() NOT NULL,
	status nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	datetime0 datetime NOT NULL,
	[datetime2] datetime NOT NULL,
	user_id0 int NULL,
	user_id2 int NULL,
	ma_td1 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	sl_td1 int NULL,
	sl_td2 int NULL,
	sl_td3 int NULL,
	gc_td1 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	gc_td2 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	gc_td3 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	s1 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	s2 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	s3 nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	s4 int NULL,
	s5 int NULL,
	s6 int NULL,
	s7 datetime NOT NULL,
	s8 datetime NOT NULL,
	s9 datetime NOT NULL,
	tk_dc nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	khong_kt_mst int NULL,
	CONSTRAINT dmkh_ma_kh_primary PRIMARY KEY (ma_kh)
);

## Output

$table->integer('ong_ba')->nullable();
$table->string('ma_nvbh')->nullable();
$table->timestamp('datetime0')->useCurrent();


## How to run

# Install javaFX 17

https://gluonhq.com/products/javafx/ -> Chose version 17
Copy file lib to current folder
Run file (1 OR 2)
 1. Run file run-app.sh  
 2. in command line input: java --module-path lib --add-modules javafx.controls,javafx.fxml -jar App.jar

