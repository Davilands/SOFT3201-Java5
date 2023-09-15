package com.poly.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	private String maNV;
	private String tenNV;
	private String email;
	private Boolean gioiTinh;
	private String viTri;
}
