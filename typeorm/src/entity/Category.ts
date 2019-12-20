import {Entity, PrimaryGeneratedColumn, Column, Timestamp, ManyToOne, JoinColumn} from "typeorm";

@Entity()
export class Category {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    title: string;
}
