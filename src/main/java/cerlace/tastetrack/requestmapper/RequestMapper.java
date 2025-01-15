package cerlace.tastetrack.requestmapper;

import javax.servlet.http.HttpServletRequest;

public interface RequestMapper<DtoT> {
    /**
     * Создает объект типа {@code DtoT}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param request объект HttpServletRequest
     * @return объект типа {@code DtoT}
     */
    DtoT getDTO(HttpServletRequest request);
}
