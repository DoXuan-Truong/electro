# 🐳 Hướng dẫn Setup Docker cho dự án Electro

## 📋 Yêu cầu hệ thống

Trước khi bắt đầu, đảm bảo máy tính đã cài đặt:

- **Docker Desktop** (phiên bản ≥ 20.10)
  - Windows: [Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/)
  - macOS: [Docker Desktop for Mac](https://docs.docker.com/desktop/install/mac-install/)
  - Linux: [Docker Engine](https://docs.docker.com/engine/install/)
- **Git** (để clone repository)

## 🚀 Cách chạy dự án (Quick Start)

### Bước 1: Clone repository

```bash
git clone <repository-url>
cd electro
```

### Bước 2: Khởi động Docker Desktop

Mở **Docker Desktop** và đợi cho đến khi nó khởi động hoàn tất.

### Bước 3: Chạy ứng dụng

```bash
docker compose up --build
```

**Chờ khoảng 3-5 phút** để Docker:
- Build ứng dụng Spring Boot (backend)
- Build ứng dụng React (frontend)  
- Khởi tạo database MySQL
- Khởi động tất cả services

### Bước 4: Truy cập ứng dụng

Sau khi tất cả containers đã **healthy**, truy cập:

- 🌐 **Frontend (Website):** http://localhost:3000
- 🚀 **Backend API:** http://localhost:8085
- 🗄️ **Database:** `localhost:3308` (username: `root`, password: `12345`)

## 📦 Cấu trúc Docker

Dự án gồm 3 containers chính:

```
┌─────────────────────┐
│  electro-client     │  (React + Nginx)
│  Port: 3000         │
└──────────┬──────────┘
           │ depends on
           ▼
┌─────────────────────┐
│  electro-server     │  (Spring Boot + Java 11)
│  Port: 8085         │
└──────────┬──────────┘
           │ depends on
           ▼
┌─────────────────────┐
│  electro-database   │  (MySQL 8.0)
│  Port: 3308         │
└─────────────────────┘
```

## 🔧 Các lệnh Docker hữu ích

### Chạy ứng dụng (lần đầu hoặc khi có thay đổi code)
```bash
docker compose up --build
```

### Chạy ứng dụng ở chế độ nền (background)
```bash
docker compose up -d
```

### Dừng ứng dụng
```bash
docker compose down
```

### Dừng và xóa tất cả dữ liệu (bao gồm database)
```bash
docker compose down -v
```

### Xem logs của tất cả services
```bash
docker compose logs
```

### Xem logs của một service cụ thể
```bash
docker compose logs electro-server
docker compose logs electro-client
docker compose logs electro-database
```

### Xem trạng thái các containers
```bash
docker ps
```

### Restart một service cụ thể
```bash
docker compose restart electro-server
```

## 🔍 Kiểm tra trạng thái

### Kiểm tra Backend API
```bash
curl http://localhost:8085/actuator/health
```

Kết quả mong đợi:
```json
{"status":"UP"}
```

### Kiểm tra Frontend
```bash
curl -I http://localhost:3000
```

Kết quả mong đợi: HTTP 200 OK

### Kiểm tra Database
```bash
docker exec -it electro-database mysql -uroot -p12345 -e "SHOW DATABASES;"
```

## ⚠️ Xử lý lỗi thường gặp

### Lỗi: "port is already allocated"

**Nguyên nhân:** Port 3000, 8085 hoặc 3308 đã được sử dụng bởi ứng dụng khác.

**Giải pháp:**
1. Tắt ứng dụng đang dùng port đó
2. Hoặc thay đổi port trong file `docker-compose.yml`

### Lỗi: Container không healthy

**Giải pháp:**
```bash
# Xem logs để tìm lỗi
docker compose logs electro-server

# Restart lại
docker compose restart
```

### Lỗi: "no space left on device"

**Giải pháp:** Dọn dẹp Docker
```bash
docker system prune -a
docker volume prune
```

### Database bị lỗi hoặc thiếu dữ liệu

**Giải pháp:** Reset lại database
```bash
docker compose down -v
docker compose up --build
```

## 🔄 Cập nhật code

Khi pull code mới từ Git:

```bash
git pull origin main
docker compose down
docker compose up --build
```

## 💡 Tips

1. **Lần đầu chạy:** Sẽ mất nhiều thời gian hơn do phải download images và build code
2. **Chạy lần sau:** Nhanh hơn nhiều vì đã có cache
3. **Khi thay đổi code:** Nhớ dùng `--build` để rebuild
4. **Muốn chạy nhanh hơn:** Bỏ `--build` nếu không có thay đổi code:
   ```bash
   docker compose up
   ```

## 📝 Thông tin kết nối

### Database
- **Host:** localhost
- **Port:** 3308
- **Database:** electro
- **Username:** root
- **Password:** 12345

### Backend API
- **Base URL:** http://localhost:8085
- **API Docs:** http://localhost:8085/swagger-ui.html (nếu có)
- **Health Check:** http://localhost:8085/actuator/health

### Frontend
- **URL:** http://localhost:3000

## 🛑 Tắt ứng dụng  

Để tắt ứng dụng an toàn:

```bash
docker compose down
```

Nếu muốn xóa luôn dữ liệu database:

```bash
docker compose down -v
```

---

## 📞 Hỗ trợ

Nếu gặp vấn đề, vui lòng:
1. Kiểm tra logs: `docker compose logs`
2. Kiểm tra trạng thái: `docker ps -a`
3. Tạo issue trên repository

---

**Chúc bạn setup thành công! 🎉**
