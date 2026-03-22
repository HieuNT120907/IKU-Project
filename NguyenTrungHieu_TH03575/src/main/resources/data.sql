-- 1. Thêm dữ liệu Người dùng (Đảm bảo có ID 1, 2, 3)
INSERT INTO users (username, password, full_name, role) VALUES ('hieunt', '12345', 'Nguyen Trung Hieu', 'ROLE_ADMIN');
INSERT INTO users (username, password, full_name, role) VALUES ('intern_test', '12345', 'Tester Intern', 'ROLE_USER');
INSERT INTO users (username, password, full_name, role) VALUES ('manh_dev', '12345', 'Le Van Manh', 'ROLE_USER');

-- 2. Dữ liệu Sản phẩm (Đảm bảo có ID từ 1 đến 6)
INSERT INTO san_phams (ten, ma, nha_san_xuat, gia, ghi_chu) VALUES ('Laptop Dell XPS', 'SP001', 'Dell', 25000000, 'Hàng cao cấp');
INSERT INTO san_phams (ten, ma, nha_san_xuat, gia, ghi_chu) VALUES ('iPhone 15 Pro', 'SP002', 'Apple', 28000000, 'Bản VN/A');
INSERT INTO san_phams (ten, ma, nha_san_xuat, gia, ghi_chu) VALUES ('Chuột Logitech G502', 'SP003', 'Logitech', 1200000, 'Chuột gaming');
INSERT INTO san_phams (ten, ma, nha_san_xuat, gia, ghi_chu) VALUES ('Macbook M3', 'SP004', 'Apple', 35000000, 'Project High-end');
INSERT INTO san_phams (ten, ma, nha_san_xuat, gia, ghi_chu) VALUES ('Bàn phím AKKO', 'SP005', 'AKKO', 2000000, 'Cơ học');
INSERT INTO san_phams (ten, ma, nha_san_xuat, gia, ghi_chu) VALUES ('Màn hình LG 27 inch', 'SP006', 'LG', 5000000, 'Project Office');

-- 3. Dữ liệu 30 Đơn hàng (Task) trình bày theo từng dòng đơn lẻ
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH001', 1, 'DONE', '2026-03-10', 1, 1);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH002', 2, 'IN_PROGRESS', '2026-03-10', 2, 2);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH003', 5, 'TODO', '2026-03-10', 2, 1);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH004', 2, 'TODO', '2026-03-10', 1, 4);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH005', 1, 'IN_PROGRESS', '2026-03-10', 2, 5);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH006', 10, 'DONE', '2026-03-10', 1, 3);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH007', 1, 'TODO', '2026-03-10', 3, 4);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH008', 3, 'IN_PROGRESS', '2026-03-10', 1, 5);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH009', 1, 'DONE', '2026-03-10', 2, 6);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH010', 4, 'TODO', '2026-03-10', 1, 1);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH011', 2, 'IN_PROGRESS', '2026-03-10', 3, 2);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH012', 1, 'DONE', '2026-03-10', 1, 3);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH013', 5, 'TODO', '2026-03-10', 2, 4);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH014', 1, 'IN_PROGRESS', '2026-03-10', 1, 5);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH015', 2, 'DONE', '2026-03-10', 2, 6);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH016', 3, 'TODO', '2026-03-10', 1, 1);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH017', 1, 'IN_PROGRESS', '2026-03-10', 3, 2);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH018', 6, 'DONE', '2026-03-10', 1, 3);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH019', 1, 'TODO', '2026-03-10', 2, 4);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH020', 2, 'IN_PROGRESS', '2026-03-10', 1, 5);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH021', 4, 'DONE', '2026-03-10', 3, 6);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH022', 1, 'TODO', '2026-03-10', 1, 1);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH023', 8, 'IN_PROGRESS', '2026-03-10', 2, 2);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH024', 2, 'DONE', '2026-03-10', 1, 3);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH025', 1, 'TODO', '2026-03-10', 3, 4);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH026', 3, 'IN_PROGRESS', '2026-03-10', 1, 5);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH027', 1, 'DONE', '2026-03-10', 2, 6);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH028', 5, 'TODO', '2026-03-10', 1, 1);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH029', 2, 'IN_PROGRESS', '2026-03-10', 3, 2);
INSERT INTO don_hangs (ma_don_hang, so_luong, trang_thai, ngay_dat, user_id, san_pham_id) VALUES ('DH030', 1, 'DONE', '2026-03-10', 1, 3);