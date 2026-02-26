# BÀI THỰC HÀNH: XÂY DỰNG WEB APP CƠ BẢN
## Trả lời câu hỏi
### Lab 1

1. Kết quả sau khi chèn vào thêm 10 sinh viên

![Query to insert 10 column](<./assets/photos/insert 10 column query.png>)
![Result of inserting 10 column](<./assets/photos/insert 10 column result.png>)

2. Sau khi chèn vào một sinh viên có id trùng với một người đã có sẵn

![alt text](./assets/photos/image.png)

Ta có thể thấy, database thông báo lỗi UNIQUE constraints failed. Lý do là vì trong một bảng dữ liệu, các khóa chính phải độc lập và không được trùng nhau. Điều này là bắt buộc để phân biệt các bản ghi trong một bảng. Nếu không, nhầm lẫn hoàn toàn có thể xảy ra. Đây là điều tiên quyết trong SQL.

3. Chèn vào một sinh viên nhưng bỏ trống cột name

![Chèn vào một sinh viên với tên để trống](./assets/photos/insert%20a%20null%20name.png)

Như ta có thể thấy, khi chèn vào một bản ghi sinh viên với cột name để trống, việc này hoàn toàn thành công. Điều này sẽ dẫn đến khi code Java truy vấn và đọc dữ liệu lên từ những học sinh mà chỉ có ID, không có tên, code sẽ phải xử lý logic để không trả về những giá trị này. Mặc dù điều này không quá ảnh hưởng đến khả năng chạy của chương trình, nhưng nó sẽ rất dễ dẫn đến những bug liên quan đến logic nghiệp vụ, ảnh hưởng không tốt đến độ tin cậy của ứng dụng.

4. Sau khi tắt và mở ứng dụng, ta thấy dữ liệu cũ trong database biến mất. Lý do là vì trong application.properties, ta đã set cho `spring.jpa.hibernate.ddl-auto=create` tức là sau khi khởi động lại ứng dụng, dữ liệu các bảng sẽ được xóa đi và tạo mới theo schema của các `@Entity` trong Java (nhờ sự trợ giúp của Spring Data Jpa). Vì vậy, các bản ghi cũ bị xóa đi.








