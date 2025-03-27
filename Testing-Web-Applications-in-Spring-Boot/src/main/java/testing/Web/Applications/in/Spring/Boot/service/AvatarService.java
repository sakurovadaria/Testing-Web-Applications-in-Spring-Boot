package testing.Web.Applications.in.Spring.Boot.service;

import testing.Web.Applications.in.Spring.Boot.model.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AvatarService {
  void uploadAvatar(Long Id, MultipartFile avatarFile) throws IOException;

    Avatar findAvatar(Long Id);
}