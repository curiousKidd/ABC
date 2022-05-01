package com.example.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileController {

	// path��� ������ servlet-context�� ������ uploadPath �ּ� �Է�
	@Resource(name = "uploadPath")
	private String path;

	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String upload(MultipartFile file) throws Exception {

		System.out.println(file.getOriginalFilename());

		// upload�� �����ϸ� file �����͸� �޾Ƽ�
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		// file�� �ִ� �������� �̸�(�������̸�), ������ ������ �޾Ƽ� �����Ѱ��� savedName�̶�� ������ ������ ���� =
		// �����ͷ� �����
		return savedName;
	}

	// �̹��� ���� ��� = ���� �̸��� �޾Ƽ� �̹��� �����ͷ� ����(display?fileName=(����� �����̸�))
	@ResponseBody
	@RequestMapping("/display")
	public byte[] display(String fileName) throws Exception {
		InputStream in = new FileInputStream(path + "/" + fileName);
		byte[] image = IOUtils.toByteArray(in);
		in.close();
		return image;
	}

	// ���ϻ���
	@ResponseBody
	@RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	public void deleteFile(String fileName) {
		System.out.println(fileName);
		new File(path + "/" + fileName).delete();
	}

	// ���� ���ε� �żҵ�
	// ������ �н��� ���ο� ��ġ���ʴ� �̸����� ������ �����Ϳ� ���ο� �̸��� ������ �н��� �����ϴ� �żҵ�
	private String uploadFile(String originalName, byte[] filedata) throws Exception {
		// ������ �������� �����̸��ް�, ������ �����͸� ����
		UUID uid = UUID.randomUUID();
		// uid�� ������ ���̵�� ��ȯ�����༭ ����(����ũ�ϰ� �̸��� �༭ ��ġ�� �ʵ���) = ��ȿ���̵�
		String savedName = uid.toString() + "_" + originalName;

		File target = new File(path, savedName); // ���� �����(path)�� savedName�� ����
		FileCopyUtils.copy(filedata, target);// copy = ������ ���ε� ��

		return savedName;
	}

	//�ٿ�ε� �żҵ�
	@ResponseBody
	@RequestMapping(value = "downloadFile")
	public ResponseEntity<byte[]> downloadFile(String fileName) throws Exception {
		System.out.println("�����̸�:" + fileName);
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(path+ "/" + fileName);
			fileName = fileName.substring(fileName.indexOf("_") + 1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attachment;filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.toString());
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
}