package com.eep.proyectoSpring.models.sevice;

import java.io.IOException;

public interface PeticionGetExterna {
	 public String sendGET(String url) throws IOException;
}
