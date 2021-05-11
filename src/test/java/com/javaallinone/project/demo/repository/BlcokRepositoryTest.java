package com.javaallinone.project.demo.repository;

import com.javaallinone.project.demo.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BlcokRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud(){
        List<Block> blockList = blockRepository.findAll();

        assertThat(blockList.size()).isEqualTo(2);
        assertThat(blockList.get(0).getName()).isEqualTo("kjb");
    }
}