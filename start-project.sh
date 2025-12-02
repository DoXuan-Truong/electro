#!/bin/bash

# ============================================================
# Electro Project Startup Script
# ============================================================
# Script để khởi động dự án Electro với Docker
# Bao gồm: MySQL Database, Spring Boot Backend, React Frontend
# ============================================================

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

print_info() {
    echo "${BLUE}ℹ️  $1${NC}"
}

print_success() {
    echo "${GREEN}✅ $1${NC}"
}

print_warning() {
    echo "${YELLOW}⚠️  $1${NC}"
}

print_error() {
    echo "${RED}❌ $1${NC}"
}

print_header() {
    echo "${BLUE}"
    echo "============================================"
    echo "  🚀 ELECTRO PROJECT STARTUP SCRIPT"
    echo "============================================"
    echo "${NC}"
}

check_docker() {
    if ! command -v docker &> /dev/null; then
        print_error "Docker chưa được cài đặt!"
        print_info "Vui lòng cài đặt Docker Desktop từ: https://www.docker.com/products/docker-desktop"
        exit 1
    fi
}

check_docker_running() {
    if ! docker info &> /dev/null; then
        print_error "Docker daemon chưa chạy!"
        print_info "Vui lòng khởi động Docker Desktop và thử lại"
        exit 1
    fi
}

check_docker_compose() {
    if ! docker compose version &> /dev/null; then
        print_error "Docker Compose không khả dụng!"
        exit 1
    fi
}

start_docker_compose() {
    print_header
    echo "Chọn chế độ khởi động:"
    echo "  1) Khởi động nhanh (không build lại)"
    echo "  2) Build và khởi động (khuyến nghị khi có thay đổi code)"
    echo "  3) Build lại hoàn toàn và khởi động"
    echo ""
    # shellcheck disable=SC2162
    read -p "Lựa chọn của bạn (1/2/3): " choice
    
    case $choice in
        1)
            print_info "Khởi động nhanh..."
            docker compose up -d
            ;;
        2)
            print_info "Build và khởi động..."
            docker compose up -d --build
            ;;
        3)
            print_info "Build lại hoàn toàn..."
            docker compose down -v
            docker compose build --no-cache
            docker compose up -d
            ;;
        *)
            print_warning "Lựa chọn không hợp lệ, sử dụng chế độ mặc định (build và khởi động)"
            docker compose up -d --build
            ;;
    esac
}

show_status() {
    echo ""
    print_info "Trạng thái các services:"
    docker compose ps
    echo ""
}

show_access_info() {
    echo "${GREEN}============================================${NC}"
    echo "${GREEN}  🎉 DỰ ÁN ĐÃ KHỞI ĐỘNG THÀNH CÔNG!${NC}"
    echo "${GREEN}============================================${NC}"
    echo ""
    echo "${BLUE}📱 Truy cập ứng dụng:${NC}"
    echo "🌐 Frontend:  ${GREEN}http://localhost:3000${NC}"
    echo "🚀 Backend :  ${GREEN}http://localhost:8085${NC}"
    echo "${GREEN}============================================${NC}"
}

main() {
    check_docker
    check_docker_running
    check_docker_compose
    start_docker_compose
    show_status
    show_access_info
}

main
