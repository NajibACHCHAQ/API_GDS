package com.API_REST.dto;


import com.API_REST.model.MvtStk;
import com.API_REST.model.SourceMvtStk;
import com.API_REST.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStk typeMvt;

    private SourceMvtStk sourceMvt;

    private Integer idEntreprise;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .sourceMvt(mvtStk.getSourceMvt())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
        mvtStk.setSourceMvt(dto.getSourceMvt());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }
}