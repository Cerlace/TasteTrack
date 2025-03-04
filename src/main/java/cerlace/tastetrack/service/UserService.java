package cerlace.tastetrack.service;

import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    /**
     * Конвертирует {@link UserDTO} в {@link UserEntity}
     * и передает на слой Repository для сохранения или обновления.
     *
     * @param dto {@link UserDTO}, который нужно записать в БД
     * @return записанный в БД {@link UserDTO} с id
     */
    UserDTO saveOrUpdate(UserDTO dto);

    /**
     * Получает из слоя Repository объект {@link UserEntity} по id и
     * конвертирует его в объект {@link UserDTO}.
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    UserDTO get(Long id);

    /**
     * Получает из слоя Repository объект {@link UserEntity} по username и
     * конвертирует его в объект {@link UserDTO}.
     *
     * @param username имя пользователя
     * @return полученная запись или null в случае, если запись не найдена
     */
    UserDTO getByUsername(String username);

    /**
     * Получает из слоя Repository список всех объектов {@link UserEntity} в БД,
     * конвертирует их в объекты {@link UserDTO}.
     *
     * @return список объектов {@link UserDTO}
     */
    List<UserDTO> getAll();

    /**
     * Получает из слоя Repository страницу объектов {@link UserEntity} в БД,
     * конвертирует их в объекты {@link UserDTO}.
     *
     * @param pageSettings объект содержащий параметры страницы.
     * @return страница объектов {@link UserDTO}
     */
    Page<UserDTO> getPage(PageSettings pageSettings);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     */
    void delete(Long id);

    /**
     * С помощью слоя Repository инициирует удаление объекта из БД
     * по имени пользователя
     *
     * @param username имя пользователя
     */
    void deleteByUsername(String username);

    /**
     * Редактирует параметры пользователя.
     *
     * @param dto {@link UserDTO} с новыми параметрами
     * @return обновленный {@link UserDTO}
     */
    UserDTO editDetails(UserDTO dto);

    /**
     * Меняет пароль пользователя.
     *
     * @param dto {@link UserDTO} с новым паролем
     * @return обновленный {@link UserDTO}
     */
    UserDTO changePassword(UserDTO dto);
}
