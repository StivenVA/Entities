package org.clubhive.utils;

import org.modelmapper.ModelMapper;

import java.util.List;

public class GenericMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> T map(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static <R,T>List<T> mapList(List<R> source, Class<T> destinationType) {
        return source.stream()
                .map(item -> modelMapper.map(item, destinationType))
                .toList();
    }


}
