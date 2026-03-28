package com.nit.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nit.model.Food;
import com.nit.model.ProofRecord;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/uploadProof")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024,
	maxFileSize = 1024 * 1024 * 5,
	maxRequestSize = 1024 * 1024 * 10
)
public class UploadProofServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Food selectedFood = (Food) session.getAttribute("selectedFood");
		String ngoUser = (String) session.getAttribute("username");

		Part filePart = request.getPart("proofImage");
		String fileName = filePart.getSubmittedFileName();

		String uploadPath = getServletContext().getRealPath("") + File.separator + "proofs";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		String savedFileName = System.currentTimeMillis() + "_" + fileName;
		if (fileName != null && !fileName.isEmpty()) {
			filePart.write(uploadPath + File.separator + savedFileName);
		}

		if (selectedFood != null) {
			ProofRecord record = new ProofRecord();
			record.setRestaurantUser(selectedFood.getRestaurantUser());
			record.setNgoUser(ngoUser);
			record.setFoodName(selectedFood.getFoodName());
			record.setQuantity(selectedFood.getQuantity());
			record.setExpiresInHours(selectedFood.getExpiresInHours());
			record.setPhone(selectedFood.getPhone());
			record.setAddress(selectedFood.getAddress());
			record.setProofImagePath("proofs/" + savedFileName);

			ServletContext context = getServletContext();
			List<ProofRecord> proofList = (List<ProofRecord>) context.getAttribute("proofList");
			if (proofList == null) {
				proofList = new ArrayList<>();
			}

			proofList.add(record);
			context.setAttribute("proofList", proofList);
		}

		session.removeAttribute("selectedFood");
		session.removeAttribute("requestSuccess");
		session.setAttribute("uploadMsg", "Image proof uploaded successfully!");

		response.sendRedirect("dashboard.jsp");
	}
}