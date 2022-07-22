import React from 'react'
import PhotoAlbum from "react-photo-album"
import CardItem from '../components/CardItem'
import '../components/Cards.css'

function Histories() {
  const photos = [
    {
        src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658402753/thua%20thien%20-%20hue/t%E1%BA%A3i_xu%E1%BB%91ng_fl3rqb.jpg",
        width: 900,
        height: 600
    },
    {
        src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658403535/thua%20thien%20-%20hue/ToanCanhHueXua_1_f40vsk.jpg",
        width: 900,
        height: 600
    },
    {
        src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658371025/thua%20thien%20-%20hue/hue-xua_ba5zdw.jpg",
        width: 900,
        height: 600
    },
    {
      src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658371026/thua%20thien%20-%20hue/50021204548_707b68dc8e_h_AEBR_pkspfe.jpg",
      width: 900,
      height: 600
  }];
  const trangtien = [
    {
        src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658403823/thua%20thien%20-%20hue/Cau-Trang-Tien-7-1024x576_qdrx7j.jpg",
        width: 900,
        height: 600
    },
    {
        src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658391028/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-05_0_sioc1k.jpg",
        width: 900,
        height: 600
    },
    {
      src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-08_ipmwro.jpg",
      width: 900,
      height: 600
  }];
  return (
    <>
      <div className='histories'><h1>Histories</h1></div>
      <div className='desc'>
        <div className='cards'>
          <h1><strong>Cầu Tràng Tiền Huế - Chứng nhân lịch sử đẹp mãi theo thời gian</strong></h1>
          <div className='cards__container'>
            <div className='cards__wrapper'>
              <div className='col-text'>
                <p>Cầu Tràng Tiền Huế được xem là biểu tượng của cố đô, mang đậm dấu ấn lịch sử qua bao thăng trầm của đất nước. Đây còn là điểm du lịch hấp dẫn thu hút mọi du khách khi đến Huế bởi vẻ đẹp duyên dáng, thơ mộng bắc qua dòng sông Hương trôi lững lờ.</p>
                <p><strong>1. Giới thiệu về Cầu Tràng Tiền </strong></p>
                <p>Cầu Tràng Tiền Huế nằm ngay trung tâm thành phố và còn được gọi là cầu Trường Tiền, cầu Thành Thái. Cầu nối liền hai bờ sông Hương với đầu phía bắc thuộc phường Phú Hòa, đầu phía nam thuộc phường Phú Hợi.

                  Đây là cây cầu đầu tiên ở khu vực Đông Dương được xây dựng theo kỹ thuật và vật liệu nhập từ phương Tây. Cầu được xây dựng bằng thép với tổng chiều dài 402,60 mét, gồm 6 nhịp dầm thép có dạng vành lượng, khẩu độ mỗi nhịp là 67 mét.</p>
                <p><strong>Lịch sử hình thành cầu Tràng Tiền</strong></p>
                <ul>
                  <li>Tháng 8/1896: Vua Thành Thái ban lệnh xây cầu bắc qua sông Hương.</li>
                  <li>Năm 1897: Cầu khởi công xây dựng. </li>
                  <li>Năm 1899: Cầu được xây dựng hoàn thành và đưa vào sử dụng, lấy tên là cầu Thành Thái.</li>
                  <li>Từ 1919 - tháng 3/1945: Cầu đổi tên thành Clémenceau - tên một vị thủ tướng Pháp thời bấy giờ.</li>
                  <li>Năm 1945: Chính quyền Trần Trọng Kim đổi tên cầu thành Nguyễn Hoàng - vị chúa có công khai phá vùng Thuận Hóa.</li>
                  <li>Sau năm 1975: Cầu có tên chính thức là cầu Trường Tiền. Đây là cái tên dân gian quen gọi do thời trước, phía tả ngạn của cầu có xưởng đúc tiền của triều Nguyễn. </li>
                  <li>Từ năm 1995 đến nay: Sau một lần trùng tu, sửa chữa, đơn vị thi công đã tự ý đổi tên Trường Tiền thành Tràng Tiền và gắn bảng tên cầu Tràng Tiền ở phía đầu cầu. Sau này, chính quyền sở tại đã đặt lại tên cầu là Trường Tiền. Tuy nhiên, từ đó đến nay, hai cái tên cầu Trường Tiền và Tràng Tiền vẫn song hành với nhau. Cầu cũng trở thành điểm đến hấp dẫn, thu hút đông đảo du khách ghé thăm trong hành trình du lịch Huế.</li>
                </ul>

                <p><strong>2. Ngắm cầu Tràng Tiền thời điểm nào đẹp nhất?&nbsp;&nbsp;</strong></p>
                <p>Từ tháng 9 đến tháng 11 là thời điểm vàng để bạn thực hiện hành trình du lịch đến xứ Huế mộng mơ. Khoảng thời gian này, cố đô ít mưa, nhiệt độ không quá nóng và ít rét hơn dịp cuối năm. Do đó bạn sẽ thoải mái thong dong dạo bước, ngắm cầu Tràng Tiền Huế bên dòng sông Hương thơ mộng và thưởng thức các món ngon đặc sản ở Chợ Đông Ba ngay bên kia bờ. </p>
                <p><strong>3. Hướng dẫn cách di chuyển đến Cầu Tràng Tiền Huế &nbsp;&nbsp;</strong></p>
                <p>Cầu Tràng Tiền Huế cách trung tâm thành phố 850 mét, để di chuyển đến cầu, bạn sẽ đi qua đường Hùng Vương hoặc đường Hoàng Hoa Thám. Tùy địa điểm lưu trú xa hay gần mà bạn có thể đi bộ đến cầu hoặc đi bằng xe máy, taxi hoặc xích lô. Bạn có thể tham khảo bản đồ du lịch Huế để biết chi tiết và thuận tiện hơn trong việc di chuyển, tham quan.</p>
                <PhotoAlbum layout="rows" photos={trangtien} />
                <hr />
              </div>
            </div>
          </div>
        </div>
      </div>
      {/* his02 */}
      <div className='desc'>
        <div className='cards'>
          <h1><strong>Thành Phố Huế</strong></h1>
          <div className='cards__container'>
            <div className='cards__wrapper'>
              <div className='col-text'>
                <p>Huế là thành phố tỉnh lỵ của tỉnh Thừa Thiên Huế, Việt Nam. Huế từng là kinh đô (cố đô Huế) của Việt Nam dưới triều Tây Sơn (1788–1801) và triều Nguyễn (1802–1945). Hiện nay, thành phố là một trong những trung tâm về văn hóa – du lịch, y tế chuyên sâu, giáo dục đào tạo, khoa học công nghệ của Miền Trung - Tây Nguyên và cả nước. Những địa danh nổi bật là sông Hương và những di sản để lại của triều đại phong kiến, Thành phố có năm danh hiệu UNESCO ở Việt Nam: Quần thể di tích Cố đô Huế (1993), Nhã nhạc cung đình Huế (2003), Mộc bản triều Nguyễn (2009), Châu bản triều Nguyễn (2014) và Hệ thống thơ văn trên kiến trúc cung đình Huế (2016). Ngoài ra, Huế còn là một trong những địa phương có di sản hát bài chòi đã được công nhận là di sản văn hóa phi vật thể của nhân loại.</p>
                <p><strong>Địa lý</strong></p>
                <p>Thành phố Huế nằm ở trung tâm tỉnh Thừa Thiên Huế, địa bàn nằm trải dài theo dòng sông Hương và có vị trí địa lý:</p>
                <ul>
                  <li>Phía đông giáp thị xã Hương Thủy và huyện Phú Vang</li>
                  <li>Phía tây giáp thị xã Hương Trà </li>
                  <li>Phía nam giáp thị xã Hương Thủy</li>
                  <li>Phía bắc giáp huyện Quảng Điền và biển Đông.</li>
                </ul>
                
                
                <p>Thành phố có diện tích 265,99 km², dân số năm 2020 là 652.572 người[2], mật độ dân số đạt 2.453 người/km².</p>
                <p>Thành phố nằm cách thủ đô Hà Nội 668 km về phía nam, cách Thành phố Hồ Chí Minh 1039 km về phía bắc và cách Đà Nẵng 95 km về phía bắc.</p>
                <p>Nằm gần dãy núi Trường Sơn, khu vực thành phố Huế là đồng bằng thuộc vùng hạ lưu sông Hương và sông Bồ, có độ cao trung bình khoảng 3 – 4 m so với mực nước biển và thường bị ngập lụt khi đầu nguồn của sông Hương (trên Dãy Trường Sơn) xảy ra mưa vừa và lớn. Khu vực đồng bằng này tương đối bằng phẳng, tuy trong đó có xen kẽ một số đồi, núi thấp như núi Ngự Bình, Đồi Vọng Cảnh...</p>
                <PhotoAlbum layout="rows" photos={photos} />
                <hr />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className='cards'>
        <h1>Check out TrlHue's Histories Destinations!</h1>
        <div className='cards__container'>
          <div className='cards__wrapper'>
            <ul className='cards__items'>
              <CardItem
                src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658369483/thua%20thien%20-%20hue/anh_hue_ve_dem_ptdfpq.jpg'
                text="Trang Tien Bridge - Hue's beautiful historical witness"
                label='Adventure'
                path='/histories'
              />
              <CardItem
                src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658369482/thua%20thien%20-%20hue/Khamphahue_Quan-the-di-tich-co-do-hue_rhikcg.jpg'
                text="Hue Imperial Citadel - Discover the history of the Nguyen Dynasty's palace"
                label='Luxury'
                path='/histories'
              />
            </ul>
            <ul className='cards__items'>
              <CardItem
                src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658367992/thua%20thien%20-%20hue/Best-things-to-do-in-Hue-Vietnam-Thien-Mu-Pagoda_zzhejb.jpg'
                text='Thien Mu Pagoda in Hue - Discover the 400-year-old sacred temple'
                label='Mystery'
                path='/histories'
              />
              <CardItem
                src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658299938/thua%20thien%20-%20hue/Hue_Travel_Guide_Vietnam_Tourism_0_jcibmd.jpg'
                text='Tomb of Tu Duc - The unique beauty of the architecture of the Nguyen Dynasty'
                label='Adventure'
                path='/histories'
              />
              <CardItem
                src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658371026/thua%20thien%20-%20hue/50021204548_707b68dc8e_h_AEBR_pkspfe.jpg'
                text='Ngo Mon Gate, Hue: Echoes of the Old Imperial Day'
                label='Adrenaline'
                path='/histories'
              />
            </ul>
          </div>
        </div>
      </div>
    </>
  )
}

export default Histories