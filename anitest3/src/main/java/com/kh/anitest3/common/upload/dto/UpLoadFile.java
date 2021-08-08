package com.kh.anitest3.common.upload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 업로드한 파일의 메타정보
 * @author mypc
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpLoadFile {
  private String store_fname; 	
  private String upload_fname; 	
  private String fsize;					
  private String ftype;					
}
